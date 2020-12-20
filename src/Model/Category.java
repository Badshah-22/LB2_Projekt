package Model;

public class Category{

    private int CategoryId;
    private double PriceCategory;
    private String CategoryType;


    public Category(int categoryId, double priceCategory, String categoryType) {
        CategoryId = categoryId;
        PriceCategory = priceCategory;
        CategoryType = categoryType;
    }

    public int getCategoryId() {

        return CategoryId;
    }

    public void setCategoryId(int categoryId) {

        CategoryId = categoryId;
    }

    public double getPriceCategory() {

        return PriceCategory;
    }

    public void setPriceCategory(double priceCategory) {

        PriceCategory = priceCategory;
    }

    public String getCategoryType() {

        return CategoryType;
    }

    public void setCategoryType(String categoryType) {

        CategoryType = categoryType;
    }
}