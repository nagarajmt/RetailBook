package com.example.emp2.expandablelistview;

/**
 * Created by EMP2 on 4/5/2017.
 */

public class CreateMaterialDTO {
    private int id;
    private String item_name;
    private String item_desc;
    private String item_cost;
    private int item_qty;
    public CreateMaterialDTO(){}

    public CreateMaterialDTO(String item_name,String item_desc,String item_cost,int item_qty ){
        super();
        this.item_name=item_name;
        this.item_desc=item_desc;
        this.item_cost=item_cost;
        this.item_qty=item_qty;
    }
    public  CreateMaterialDTO(String item_name,String item_cost,int item_qty){
        this.item_name=item_name;
        this.item_cost=item_cost;
        this.item_qty=item_qty;
    }
    public int getItem_qty() {
        return item_qty;
    }

    public void setItem_qty(int item_qty) {
        this.item_qty = item_qty;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getItem_cost() {
        return item_cost;
    }

    public void setItem_cost(String item_cost) {
        this.item_cost = item_cost;
    }

    @Override
    public String toString() {
        return "CreateMaterialDTO [Id=" + id + "item Name =" +item_name +"item desc="+item_desc+
                "item cost="+item_cost+ "item qty"+item_qty+"]";
    }
}
