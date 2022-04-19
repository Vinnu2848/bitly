
package request;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CreateBitlink {

    @SerializedName("long_url")
    @Expose
    private String longUrl;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("group_guid")
    @Expose
    private String groupGuid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CreateBitlink() {
    }

    /**
     * 
     * @param domain
     * @param longUrl
     * @param title
     * @param groupGuid
     * @param tags
     */
    public CreateBitlink(String longUrl, String domain, String groupGuid, String title, List<String> tags) {
        super();
        this.longUrl = longUrl;
        this.domain = domain;
        this.groupGuid = groupGuid;
        this.title = title;
        this.tags = tags;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getGroupGuid() {
        return groupGuid;
    }

    public void setGroupGuid(String groupGuid) {
        this.groupGuid = groupGuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CreateBitlink.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("longUrl");
        sb.append('=');
        sb.append(((this.longUrl == null)?"<null>":this.longUrl));
        sb.append(',');
        sb.append("domain");
        sb.append('=');
        sb.append(((this.domain == null)?"<null>":this.domain));
        sb.append(',');
        sb.append("groupGuid");
        sb.append('=');
        sb.append(((this.groupGuid == null)?"<null>":this.groupGuid));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
