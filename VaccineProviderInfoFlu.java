// Tom Nguyen
// 12/1/24
// CPSC 39 project
// Getters and setters and constructor for Flu vaccine locations

public class VaccineProviderInfoFlu {
    // Instance variables
    private String providerLocationGuid;
    private String locStoreNo;
    private String locPhone;
    private String locName;
    private String locAdminStreet1;
    private String locAdminStreet2;
    private String locAdminCity;
    private String locAdminState;
    private String locAdminZip;
    private String sundayHours;
    private String mondayHours;
    private String tuesdayHours;
    private String wednesdayHours;
    private String thursdayHours;
    private String fridayHours;
    private String saturdayHours;
    private String webAddress;
    private String preScreen;
    private String insuranceAccepted;
    private String walkinsAccepted;
    private String providerNotes;
    private String searchableName;
    private boolean inStock;
    private String supplyLevel;
    private String quantityLastUpdated;
    private String latitude;
    private String longitude;
    private String category;

    // Constructor
    public VaccineProviderInfoFlu(String providerLocationGuid, String locStoreNo, String locPhone, String locName,
                                  String locAdminStreet1, String locAdminStreet2, String locAdminCity, String locAdminState,
                                  String locAdminZip, String sundayHours, String mondayHours, String tuesdayHours,
                                  String wednesdayHours, String thursdayHours, String fridayHours, String saturdayHours,
                                  String webAddress, String preScreen, String insuranceAccepted, String walkinsAccepted,
                                  String providerNotes, String searchableName, boolean inStock, String supplyLevel,
                                  String quantityLastUpdated, String latitude, String longitude, String category) {
        this.providerLocationGuid = providerLocationGuid;
        this.locStoreNo = locStoreNo;
        this.locPhone = locPhone;
        this.locName = locName;
        this.locAdminStreet1 = locAdminStreet1;
        this.locAdminStreet2 = locAdminStreet2;
        this.locAdminCity = locAdminCity;
        this.locAdminState = locAdminState;
        this.locAdminZip = locAdminZip;
        this.sundayHours = sundayHours;
        this.mondayHours = mondayHours;
        this.tuesdayHours = tuesdayHours;
        this.wednesdayHours = wednesdayHours;
        this.thursdayHours = thursdayHours;
        this.fridayHours = fridayHours;
        this.saturdayHours = saturdayHours;
        this.webAddress = webAddress;
        this.preScreen = preScreen;
        this.insuranceAccepted = insuranceAccepted;
        this.walkinsAccepted = walkinsAccepted;
        this.providerNotes = providerNotes;
        this.searchableName = searchableName;
        this.inStock = inStock;
        this.supplyLevel = supplyLevel;
        this.quantityLastUpdated = quantityLastUpdated;
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
    }

    // Getters for all fields
    public String getProviderLocationGuid() {
        return providerLocationGuid;
    }

    public String getLocStoreNo() {
        return locStoreNo;
    }

    public String getLocPhone() {
        return locPhone;
    }

    public String getLocName() {
        return locName;
    }

    public String getLocAdminStreet1() {
        return locAdminStreet1;
    }

    public String getLocAdminStreet2() {
        return locAdminStreet2;
    }

    public String getLocAdminCity() {
        return locAdminCity;
    }

    public String getLocAdminState() {
        return locAdminState;
    }

    public String getLocAdminZip() {
        return locAdminZip;
    }

    public String getSundayHours() {
        return sundayHours;
    }

    public String getMondayHours() {
        return mondayHours;
    }

    public String getTuesdayHours() {
        return tuesdayHours;
    }

    public String getWednesdayHours() {
        return wednesdayHours;
    }

    public String getThursdayHours() {
        return thursdayHours;
    }

    public String getFridayHours() {
        return fridayHours;
    }

    public String getSaturdayHours() {
        return saturdayHours;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public String getPreScreen() {
        return preScreen;
    }

    public String getInsuranceAccepted() {
        return insuranceAccepted;
    }

    public String getWalkinsAccepted() {
        return walkinsAccepted;
    }

    public String getProviderNotes() {
        return providerNotes;
    }

    public String getSearchableName() {
        return searchableName;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getSupplyLevel() {
        return supplyLevel;
    }

    public String getQuantityLastUpdated() {
        return quantityLastUpdated;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCategory() {
        return category;
    }


    // Overriding the toString method
    @Override
    public String toString() {
        return "VaccineProviderInfoFlu {" +
                // "providerLocationGuid='" + providerLocationGuid + '\'' +
                // ", locStoreNo='" + locStoreNo + '\'' +
                ", locPhone='" + locPhone + '\'' +
                ", locName='" + locName + '\'' +
                ", locAdminStreet1='" + locAdminStreet1 + '\'' +
                // ", locAdminStreet2='" + locAdminStreet2 + '\'' +
                ", locAdminCity='" + locAdminCity + '\'' +
                ", locAdminState='" + locAdminState + '\'' +
                ", locAdminZip='" + locAdminZip + '\'' +
                //", sundayHours='" + sundayHours + '\'' +
                //", mondayHours='" + mondayHours + '\'' +
                //", tuesdayHours='" + tuesdayHours + '\'' +
                //", wednesdayHours='" + wednesdayHours + '\'' +
                //", thursdayHours='" + thursdayHours + '\'' +
                //", fridayHours='" + fridayHours + '\'' +
                //", saturdayHours='" + saturdayHours + '\'' +
                //", webAddress='" + webAddress + '\'' +
                //", preScreen='" + preScreen + '\'' +
                //", insuranceAccepted='" + insuranceAccepted + '\'' +
                //", walkinsAccepted='" + walkinsAccepted + '\'' +
                ", providerNotes='" + providerNotes + '\'' +
                ", searchableName='" + searchableName + '\'' +
                //", inStock=" + inStock +
                // ", supplyLevel='" + supplyLevel + '\'' +
                // ", quantityLastUpdated='" + quantityLastUpdated + '\'' +
                // ", latitude='" + latitude + '\'' +
                //", longitude='" + longitude + '\'' +
                //", category='" + category + '\'' +
                '}';
    }
}
