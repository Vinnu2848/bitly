
package response.CreateBitlLinks;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CreateBitlink {

    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("custom_bitlinks")
    @Expose
    private List<Object> customBitlinks = null;
    @SerializedName("long_url")
    @Expose
    private String longUrl;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("deeplinks")
    @Expose
    private List<Object> deeplinks = null;
    @SerializedName("references")
    @Expose
    private References references;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CreateBitlink() {
    }

    /**
     * 
     * @param createdAt
     * @param archived
     * @param deeplinks
     * @param references
     * @param link
     * @param longUrl
     * @param id
     * @param customBitlinks
     * @param title
     * @param tags
     */
    public CreateBitlink(String createdAt, String id, String link, List<Object> customBitlinks, String longUrl, String title, Boolean archived, List<String> tags, List<Object> deeplinks, References references) {
        super();
        this.createdAt = createdAt;
        this.id = id;
        this.link = link;
        this.customBitlinks = customBitlinks;
        this.longUrl = longUrl;
        this.title = title;
        this.archived = archived;
        this.tags = tags;
        this.deeplinks = deeplinks;
        this.references = references;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Object> getCustomBitlinks() {
        return customBitlinks;
    }

    public void setCustomBitlinks(List<Object> customBitlinks) {
        this.customBitlinks = customBitlinks;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Object> getDeeplinks() {
        return deeplinks;
    }

    public void setDeeplinks(List<Object> deeplinks) {
        this.deeplinks = deeplinks;
    }

    public References getReferences() {
        return references;
    }

    public void setReferences(References references) {
        this.references = references;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreateBitlink.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("link");
        sb.append('=');
        sb.append(((this.link == null)?"<null>":this.link));
        sb.append(',');
        sb.append("customBitlinks");
        sb.append('=');
        sb.append(((this.customBitlinks == null)?"<null>":this.customBitlinks));
        sb.append(',');
        sb.append("longUrl");
        sb.append('=');
        sb.append(((this.longUrl == null)?"<null>":this.longUrl));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("archived");
        sb.append('=');
        sb.append(((this.archived == null)?"<null>":this.archived));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("deeplinks");
        sb.append('=');
        sb.append(((this.deeplinks == null)?"<null>":this.deeplinks));
        sb.append(',');
        sb.append("references");
        sb.append('=');
        sb.append(((this.references == null)?"<null>":this.references));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
