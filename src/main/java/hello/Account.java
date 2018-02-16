package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Account {

    @JsonProperty(value="Id")
    String id;
    @JsonProperty(value="Name")
    String name;
    @JsonProperty(value="AnnualRevenue")
    private Double annualRevenue;
    @JsonProperty(value="Description")
    String description;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getAnnualRevenue() { return annualRevenue; }
    public void setAnnualRevenue(Double value) { annualRevenue = value; }
    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }
}