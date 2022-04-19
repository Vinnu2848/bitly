
package response.getBitlinks;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Getbitlinks {

    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    @SerializedName("sorted_links")
    @Expose
    private List<SortedLink> sortedLinks = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Getbitlinks() {
    }

    /**
     * 
     * @param links
     * @param sortedLinks
     */
    public Getbitlinks(List<Link> links, List<SortedLink> sortedLinks) {
        super();
        this.links = links;
        this.sortedLinks = sortedLinks;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<SortedLink> getSortedLinks() {
        return sortedLinks;
    }

    public void setSortedLinks(List<SortedLink> sortedLinks) {
        this.sortedLinks = sortedLinks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Getbitlinks.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("sortedLinks");
        sb.append('=');
        sb.append(((this.sortedLinks == null)?"<null>":this.sortedLinks));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
