package nextstep.courses.infrastructure;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import nextstep.courses.domain.Course;
import nextstep.courses.domain.CoverImageInfo;
import nextstep.courses.domain.CoverImageInfoRepository;
import nextstep.courses.domain.PaySession;
import nextstep.courses.domain.SessionDate;
import nextstep.courses.domain.SessionInfos;
import nextstep.courses.domain.SessionRepository;
import nextstep.courses.domain.enums.SessionType;

@JdbcTest
public class SessionRepositoryTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionRepositoryTest.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

	private SessionRepository sessionRepository;
	private CoverImageInfo savedCoverImageInfo;
	@BeforeEach
	void setUp() {
		sessionRepository = new JdbcSessionRepository(jdbcTemplate, dataSource);
		CoverImageInfoRepository coverImageInfoRepository = new JdbcCoverImageInfoRepository(jdbcTemplate, dataSource);
		CoverImageInfo coverImageInfo = CoverImageInfo.createNewInstance(1000L, "jpg", 300L, 200L);
		Long savedCoverImageInfoId = coverImageInfoRepository.saveAndGetId(coverImageInfo);
		savedCoverImageInfo = coverImageInfoRepository.findById(savedCoverImageInfoId);
	}

	@Test
	@DisplayName("유료 강의 CRUD")
	void paysession_crud() {
		// given
		SessionDate sessionDate = SessionDate.of(LocalDateTime.of(2024, 04, 07, 10, 11), LocalDateTime.now());
		PaySession session = PaySession.createNewInstance(
			new Course(),
			SessionInfos.createWithReadyStatus(sessionDate),
			20,
			savedCoverImageInfo,
			20000L
		);
		Long savedId = sessionRepository.saveSessionAndGetId(session);

		PaySession savedSession = (PaySession) sessionRepository.findById(savedId);

		assertThat(savedSession.getType()).isEqualTo(SessionType.PAY);
		assertThat(savedSession.getMaxNumberOfStudents()).isEqualTo(20);

		LOGGER.debug("PaySession: {}", savedSession);
	}
}