package nextstep.session.dto;

import java.time.LocalDateTime;

public class CoverVO {

    private final long id;
    private final long sessionId;
    private final int width;
    private final int height;
    private final String filePath;
    private final String fileName;
    private final String fileExtension;
    private final long byteSize;
    private final boolean deleted;
    private final String writerId;
    private final LocalDateTime createdAt;
    private final LocalDateTime lastModifiedAt;

    public CoverVO(
            long id, long sessionId, int width, int height, String filePath, String fileName, String fileExtension,
            long byteSize, String writerId, boolean deleted, LocalDateTime createdAt, LocalDateTime lastModifiedAt
    ) {
        this.id = id;
        this.sessionId = sessionId;
        this.width = width;
        this.height = height;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.byteSize = byteSize;
        this.writerId = writerId;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
    }

    public long getId() {
        return id;
    }

    public long getSessionId() {
        return sessionId;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public long getByteSize() {
        return byteSize;
    }

    public String getWriterId() {
        return writerId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastModifiedAt() {
        return lastModifiedAt;
    }
}