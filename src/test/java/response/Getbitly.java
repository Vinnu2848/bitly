
package response;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "created",
    "modified",
    "bsds",
    "guid",
    "organization_guid",
    "name",
    "is_active",
    "role",
    "references"
})
@Generated("jsonschema2pojo")
public class Getbitly {

    @JsonProperty("created")
    private String created;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("bsds")
    private List<Object> bsds = null;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("organization_guid")
    private String organizationGuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("is_active")
    private Boolean isActive;
    @JsonProperty("role")
    private String role;
    @JsonProperty("references")
    private References references;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Getbitly() {
    }

    /**
     * 
     * @param role
     * @param references
     * @param created
     * @param name
     * @param modified
     * @param guid
     * @param organizationGuid
     * @param isActive
     * @param bsds
     */
    public Getbitly(String created, String modified, List<Object> bsds, String guid, String organizationGuid, String name, Boolean isActive, String role, References references) {
        super();
        this.created = created;
        this.modified = modified;
        this.bsds = bsds;
        this.guid = guid;
        this.organizationGuid = organizationGuid;
        this.name = name;
        this.isActive = isActive;
        this.role = role;
        this.references = references;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }

    @JsonProperty("bsds")
    public List<Object> getBsds() {
        return bsds;
    }

    @JsonProperty("bsds")
    public void setBsds(List<Object> bsds) {
        this.bsds = bsds;
    }

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("organization_guid")
    public String getOrganizationGuid() {
        return organizationGuid;
    }

    @JsonProperty("organization_guid")
    public void setOrganizationGuid(String organizationGuid) {
        this.organizationGuid = organizationGuid;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("is_active")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("is_active")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("references")
    public References getReferences() {
        return references;
    }

    @JsonProperty("references")
    public void setReferences(References references) {
        this.references = references;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Getbitly.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("created");
        sb.append('=');
        sb.append(((this.created == null)?"<null>":this.created));
        sb.append(',');
        sb.append("modified");
        sb.append('=');
        sb.append(((this.modified == null)?"<null>":this.modified));
        sb.append(',');
        sb.append("bsds");
        sb.append('=');
        sb.append(((this.bsds == null)?"<null>":this.bsds));
        sb.append(',');
        sb.append("guid");
        sb.append('=');
        sb.append(((this.guid == null)?"<null>":this.guid));
        sb.append(',');
        sb.append("organizationGuid");
        sb.append('=');
        sb.append(((this.organizationGuid == null)?"<null>":this.organizationGuid));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("isActive");
        sb.append('=');
        sb.append(((this.isActive == null)?"<null>":this.isActive));
        sb.append(',');
        sb.append("role");
        sb.append('=');
        sb.append(((this.role == null)?"<null>":this.role));
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
