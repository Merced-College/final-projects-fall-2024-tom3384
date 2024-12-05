// Tom Nguyen
// 11/29/24
// CPSC 39 project
// Getters and setters and constructor for COVID vaccine locations


// provider_location_guid	loc_store_no	loc_phone	loc_name	loc_admin_street1	loc_admin_street2	loc_admin_city	loc_admin_state	loc_admin_zip	sunday_hours	monday_hours	tuesday_hours	wednesday_hours	thursday_hours	friday_hours	saturday_hours	web_address	pre_screen	insurance_accepted	walkins_accepted	provider_notes	ndc	med_name	in_stock	supply_level	quantity_last_updated	latitude	longitude	Category	Unnamed Column	offers_free_masks	min_age_months	min_age_years	bridge_access_program

import java.util.Objects;

public class VaccineProviderInfo {
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
    private String ndc;
    private String medName;
    private boolean inStock;
    private String supplyLevel;
    private String quantityLastUpdated;
    private String latitude;
    private String longitude;
    private String category;
    private String unnamedColumn;
    private boolean offersFreeMasks;
    private int minAgeMonths;
    private int minAgeYears;
    private boolean bridgeAccessProgram;

    // Constructor
    public VaccineProviderInfo(String providerLocationGuid, String locStoreNo, String locPhone, String locName,
                        String locAdminStreet1, String locAdminStreet2, String locAdminCity, String locAdminState,
                        String locAdminZip, String sundayHours, String mondayHours, String tuesdayHours,
                        String wednesdayHours, String thursdayHours, String fridayHours, String saturdayHours,
                        String webAddress, String preScreen, String insuranceAccepted, String walkinsAccepted,
                        String providerNotes, String ndc, String medName, boolean inStock, String supplyLevel,
                        String quantityLastUpdated, String latitude, String longitude, String category,
                        String unnamedColumn, boolean offersFreeMasks, int minAgeMonths, int minAgeYears,
                        boolean bridgeAccessProgram) {
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
        this.ndc = ndc;
        this.medName = medName;
        this.inStock = inStock;
        this.supplyLevel = supplyLevel;
        this.quantityLastUpdated = quantityLastUpdated;
        this.latitude = latitude; //26 (zero indexed)
        this.longitude = longitude; //27
        this.category = category; //28
        this.unnamedColumn = unnamedColumn; //29
        this.offersFreeMasks = offersFreeMasks; //30
        this.minAgeMonths = minAgeMonths; //31 
        this.minAgeYears = minAgeYears; //32 
        this.bridgeAccessProgram = bridgeAccessProgram; //33
    }

    // Setters and getters are methods used to control access to a class's private variables. They help protect the data, when creating classes. 
    // A getter method returns a value while the setter sets or updates the value. 
    // Getters and Setters
    public String getProviderLocationGuid() {
        return providerLocationGuid;
    }

    public void setProviderLocationGuid(String providerLocationGuid) {
        this.providerLocationGuid = providerLocationGuid;
    }

    public String getLocStoreNo() {
        return locStoreNo;
    }

    public void setLocStoreNo(String locStoreNo) {
        this.locStoreNo = locStoreNo;
    }

    public String getLocPhone() {
        return locPhone;
    }

    public void setLocPhone(String locPhone) {
        this.locPhone = locPhone;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocAdminStreet1() {
        return locAdminStreet1;
    }

    public void setLocAdminStreet1(String locAdminStreet1) {
        this.locAdminStreet1 = locAdminStreet1;
    }

    public String getLocAdminStreet2() {
        return locAdminStreet2;
    }

    public void setLocAdminStreet2(String locAdminStreet2) {
        this.locAdminStreet2 = locAdminStreet2;
    }

    public String getLocAdminCity() {
        return locAdminCity;
    }

    public void setLocAdminCity(String locAdminCity) {
        this.locAdminCity = locAdminCity;
    }

    public String getLocAdminState() {
        return locAdminState;
    }

    public void setLocAdminState(String locAdminState) {
        this.locAdminState = locAdminState;
    }

    public String getLocAdminZip() {
        return locAdminZip;
    }

    public void setLocAdminZip(String locAdminZip) {
        this.locAdminZip = locAdminZip;
    }

    public String getSundayHours() {
        return sundayHours;
    }

    public void setSundayHours(String sundayHours) {
        this.sundayHours = sundayHours;
    }

    public String getMondayHours() {
        return mondayHours;
    }

    public void setMondayHours(String mondayHours) {
        this.mondayHours = mondayHours;
    }

    public String getTuesdayHours() {
        return tuesdayHours;
    }

    public void setTuesdayHours(String tuesdayHours) {
        this.tuesdayHours = tuesdayHours;
    }

    public String getWednesdayHours() {
        return wednesdayHours;
    }

    public void setWednesdayHours(String wednesdayHours) {
        this.wednesdayHours = wednesdayHours;
    }

    public String getThursdayHours() {
        return thursdayHours;
    }

    public void setThursdayHours(String thursdayHours) {
        this.thursdayHours = thursdayHours;
    }

    public String getFridayHours() {
        return fridayHours;
    }

    public void setFridayHours(String fridayHours) {
        this.fridayHours = fridayHours;
    }

    public String getSaturdayHours() {
        return saturdayHours;
    }

    public void setSaturdayHours(String saturdayHours) {
        this.saturdayHours = saturdayHours;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getPreScreen() {
        return preScreen;
    }

    public void setPreScreen(String preScreen) {
        this.preScreen = preScreen;
    }

    public String getInsuranceAccepted() {
        return insuranceAccepted;
    }

    public void setInsuranceAccepted(String insuranceAccepted) {
        this.insuranceAccepted = insuranceAccepted;
    }

    public String getWalkinsAccepted() {
        return walkinsAccepted;
    }

    public void setWalkinsAccepted(String walkinsAccepted) {
        this.walkinsAccepted = walkinsAccepted;
    }

    public String getProviderNotes() {
        return providerNotes;
    }

    public void setProviderNotes(String providerNotes) {
        this.providerNotes = providerNotes;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getSupplyLevel() {
        return supplyLevel;
    }

    public void setSupplyLevel(String supplyLevel) {
        this.supplyLevel = supplyLevel;
    }

    public String getQuantityLastUpdated() {
        return quantityLastUpdated;
    }

    public void setQuantityLastUpdated(String quantityLastUpdated) {
        this.quantityLastUpdated = quantityLastUpdated;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnnamedColumn() {
        return unnamedColumn;
    }

    public void setUnnamedColumn(String unnamedColumn) {
        this.unnamedColumn = unnamedColumn;
    }

    public boolean isOffersFreeMasks() {
        return offersFreeMasks;
    }

    public void setOffersFreeMasks(boolean offersFreeMasks) {
        this.offersFreeMasks = offersFreeMasks;
    }

    public int getMinAgeMonths() {
        return minAgeMonths;
    }

    public void setMinAgeMonths(int minAgeMonths) {
        this.minAgeMonths = minAgeMonths;
    }

    public int getMinAgeYears() {
        return minAgeYears;
    }

    public void setMinAgeYears(int minAgeYears) {
        this.minAgeYears = minAgeYears;
    }

    public boolean isBridgeAccessProgram() {
        return bridgeAccessProgram;
    } 



    // *    Title: Converting Arraylist into HashSet datatype to remove duplicates. This is because a hashset only allows unique elements. Adding an object to the Hashset automatically checks for duplicates based on the equals and hashCode methods that I put in the VaccineProviderInfo.java file.
    // *    Author: Chatgpt
    // *    Date: 2024
    // *    Availability: http://www.chatgpt.com
    // Convert the ArrayList to a HashSet to remove duplicates
    // Indicates that a method declaration is intended to override a method declaration in a supertype
    // These equals and hashCode methods help properly detect the duplicates in the phone number and street address. 
    // Better to use phone number rather than store number, since not every independent pharmacy has a store number (it's just for chain pharmacies).
    @Override
    public boolean equals(Object o) {
        // If the two objects are the same instance (same memory address), they are equal.
        if (this == o) return true;

        // Checks if the other object is null or of a different class (if so, then they cannot be equal)
        if (o == null || getClass() != o.getClass()) return false;

        // Cast the object to the same/correct class to compare specific fields 
        VaccineProviderInfo that = (VaccineProviderInfo) o;

        // Compare the relevant fields for equality, this way we can remove the duplicates of the same store number and the street address. 
        return locPhone.equals(that.locPhone) &&
               locAdminStreet1.equalsIgnoreCase(that.locAdminStreet1); // Case-insensitive
    }

    // Use equals to define what makes two objects equal.
    // Use hashCode to ensure equal objects generate the same hash value.

    // The hashCode method generates a unique integer for each object based on its fields. Two objects that are equal (based on equals) must have the same hashCode.
    // hashCode ensures that equal objects generate the same hash code, which is critical for performance in hash-based collections (like HashSet).
    @Override
    public int hashCode() {
        // Combines the hash codes of the provided fields into one hash code. 
        // Two objects considered equal by equals will have the same hash code, which is a requirement in Java.
        return Objects.hash(locPhone.toLowerCase(), locAdminStreet1.toLowerCase());
    }

    //  the default toString method of the Object class is being called for your VaccineProviderInfo objects if we don't have a toString method written

    // We need to create a toString method to override the default method, otherwise the code will output VaccineProviderInfo@63f34170, etc. 
    @Override
    public String toString() {
        // Added a new line to help declutter the code output, otherwise it looks too messy. 
        System.out.println();
        return "Vaccine Location: {" +
                // "providerLocationGuid='" + providerLocationGuid + '\'' +
                // ", locStoreNo='" + locStoreNo + '\'' +
                "Phone='" + locPhone + '\'' +
                ", Name='" + locName + '\'' +
                ", Street='" + locAdminStreet1 + '\'' +
                // ", locAdminStreet2='" + locAdminStreet2 + '\'' +
                ", City='" + locAdminCity + '\'' +
                ", State='" + locAdminState + '\'' +
                ", Zip='" + locAdminZip + '\'' +
                ", sundayHours='" + sundayHours + '\'' +
                ", mondayHours='" + mondayHours + '\'' +
                // ", tuesdayHours='" + tuesdayHours + '\'' +
                // ", wednesdayHours='" + wednesdayHours + '\'' +
                // ", thursdayHours='" + thursdayHours + '\'' +
                // ", fridayHours='" + fridayHours + '\'' +
                ", saturdayHours='" + saturdayHours + '\'' +
                ", webAddress='" + webAddress + '\'' +
                // ", preScreen='" + preScreen + '\'' +
                ", insuranceAccepted='" + insuranceAccepted + '\'' +
                ", walkinsAccepted='" + walkinsAccepted + '\'' +
                ", providerNotes='" + providerNotes + '\'' +
                // ", ndc='" + ndc + '\'' +
                ", medName='" + medName + '\'' +
                // ", inStock=" + inStock +
                // ", supplyLevel='" + supplyLevel + '\'' +
                // ", quantityLastUpdated='" + quantityLastUpdated + '\'' +
                // ", latitude='" + latitude + '\'' +
                // ", longitude='" + longitude + '\'' +
                // ", category='" + category + '\'' +
                // ", unnamedColumn='" + unnamedColumn + '\'' +
                // ", offersFreeMasks=" + offersFreeMasks +
                ", minAgeMonths=" + minAgeMonths +
                ", minAgeYears=" + minAgeYears +
                // ", bridgeAccessProgram=" + bridgeAccessProgram +
                '}';
    }   

}