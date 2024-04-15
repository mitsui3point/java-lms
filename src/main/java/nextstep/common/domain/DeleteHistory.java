package nextstep.common.domain;

import nextstep.common.dto.DeleteHistoryDto;
import nextstep.qna.domain.ContentType;
import nextstep.users.domain.NsUser;

import java.time.LocalDateTime;
import java.util.Objects;

public class DeleteHistory {
    private Long id;

    private ContentType contentType;

    private Long contentId;

    private NsUser deletedBy;

    private LocalDateTime createdDate = LocalDateTime.now();

    public static DeleteHistory createQuestion(Long contentId, NsUser deletedBy, LocalDateTime createdDate) {
        return new DeleteHistory(ContentType.QUESTION, contentId, deletedBy, createdDate);
    }

    public static DeleteHistory createAnswer(Long contentId, NsUser deletedBy, LocalDateTime createdDate) {
        return new DeleteHistory(ContentType.ANSWER, contentId, deletedBy, createdDate);
    }

    public static DeleteHistory createCover(Long contentId, NsUser deletedBy, LocalDateTime createdDate) {
        return new DeleteHistory(ContentType.COVER, contentId, deletedBy, createdDate);
    }

    public static DeleteHistory createStudent(Long contentId, NsUser deletedBy, LocalDateTime createdDate) {
        return new DeleteHistory(ContentType.STUDENT, contentId, deletedBy, createdDate);
    }

    public static DeleteHistory createSession(Long contentId, NsUser deletedBy, LocalDateTime createdDate) {
        return new DeleteHistory(ContentType.SESSION, contentId, deletedBy, createdDate);
    }

    private DeleteHistory() {
    }

    private DeleteHistory(ContentType contentType, Long contentId, NsUser deletedBy, LocalDateTime createdDate) {
        this.contentType = contentType;
        this.contentId = contentId;
        this.deletedBy = deletedBy;
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteHistory that = (DeleteHistory) o;
        return Objects.equals(id, that.id) &&
                contentType == that.contentType &&
                Objects.equals(contentId, that.contentId) &&
                Objects.equals(deletedBy, that.deletedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contentType, contentId, deletedBy);
    }

    @Override
    public String toString() {
        return "DeleteHistory [id=" + id + ", contentType=" + contentType + ", contentId=" + contentId + ", deletedBy="
                + deletedBy + ", createdDate=" + createdDate + "]";
    }

    public DeleteHistoryDto toVO() {
        return new DeleteHistoryDto(
                this.id,
                this.contentId,
                this.contentType.name(),
                this.createdDate,
                this.deletedBy.getId()
        );
    }
}