package ra.practicejsp_jstl_15112023.model;

public class Newspaper {
    private String imageUrl;
    private String title;
    private String content;
    private String author;

    public Newspaper() {
    }

    public Newspaper(String imageUrl, String title, String content, String author) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
