
package response.getBitlinks;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class SortedLink {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("clicks")
    @Expose
    private Integer clicks;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SortedLink() {
    }

    /**
     * 
     * @param clicks
     * @param id
     */
    public SortedLink(String id, Integer clicks) {
        super();
        this.id = id;
        this.clicks = clicks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SortedLink.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("clicks");
        sb.append('=');
        sb.append(((this.clicks == null)?"<null>":this.clicks));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
