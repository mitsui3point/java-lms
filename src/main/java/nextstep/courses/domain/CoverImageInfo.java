package nextstep.courses.domain;

import nextstep.courses.domain.enums.ImageType;

import java.util.Optional;

public class CoverImageInfo {
	private static final String IMAGE_SIZE_OVER_MESSAGE = "이미지 크기는 1024KB(1MB) 이하여야 합니다.";
	private static final String IMAGE_TYPE_INVALID_MESSAGE = "이미지 타입은 gif, jpg(jpeg 포함), png, svg만 가능합니다.";
	private static final String IMAGE_WIDTH_UNDER_MESSAGE = "이미지의 너비는 300 픽셀 이상이어야 합니다.";
	private static final String IMAGE_HEIGHT_UNDER_MESSAGE = "이미지의 높이는 200 픽셀 이상이어야 합니다.";
	private static final String IMAGE_WRONG_WIDTH_HEIGHT_RATE_MESSAGE = "이미지의 너비와 높이는 3:2 비율이어야 합니다.";

	private static final Long MAX_IMAGE_SIZE = 1024L;
	private static final Long MIN_IMAGE_WIDTH = 300L;
	private static final Long MIN_IMAGE_HEIGHT = 200L;
	private static final Long WIDTH_RATE = 3L;
	private static final Long HEIGHT_RATE = 2L;

	private Long id;
	private final Long size;
	private final ImageType imageType;
	private final Long width;
	private final Long height;

	public static CoverImageInfo createNewInstance(Long size, String imageTypeStr, Long width, Long height) {
		return new CoverImageInfo(0L, size, imageTypeStr, width, height);
	}

	public static CoverImageInfo createFromData(Long id, Long size, String imageTypeStr, Long width, Long height) {
		return new CoverImageInfo(id, size, imageTypeStr, width, height);
	}

	private CoverImageInfo(Long id, Long size, String imageTypeStr, Long width, Long height) {
		validateImageSize(size);
		validateWidthAndHeight(width, height);
		this.id = id;
		this.imageType = validatedImageType(imageTypeStr);
		this.size = size;
		this.width = width;
		this.height = height;
	}

	private static void validateImageSize(Long size) {
		if (size > MAX_IMAGE_SIZE) {
			throw new IllegalArgumentException(IMAGE_SIZE_OVER_MESSAGE);
		}
	}

	private ImageType validatedImageType(String imageTypeStr) {
		Optional<ImageType> imageType = ImageType.findByType(imageTypeStr);
		return imageType.orElseThrow(() -> new IllegalArgumentException(IMAGE_TYPE_INVALID_MESSAGE));
	}

	private void validateWidthAndHeight(Long width, Long height) {
		if (width < MIN_IMAGE_WIDTH) {
			throw new IllegalArgumentException(IMAGE_WIDTH_UNDER_MESSAGE);
		}

		if (height < MIN_IMAGE_HEIGHT) {
			throw new IllegalArgumentException(IMAGE_HEIGHT_UNDER_MESSAGE);
		}

		if (isCorrectImageRate(width, height)) {
			throw new IllegalArgumentException(IMAGE_WRONG_WIDTH_HEIGHT_RATE_MESSAGE);
		}
	}

	public Long getId() {
		return id;
	}

	public Long getSize() {
		return size;
	}

	public ImageType getImageType() {
		return imageType;
	}

	public Long getWidth() {
		return width;
	}

	public Long getHeight() {
		return height;
	}

	private static boolean isCorrectImageRate(Long width, Long height) {
		return WIDTH_RATE * height != HEIGHT_RATE * width;
	}

}