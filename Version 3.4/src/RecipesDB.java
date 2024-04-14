public class RecipesDB {

    public void getReviews(){
        //select all the recipe ids and names where the status is "Review"
    }
    public void getApproves(){
        //select all the recipe ids and names where the status is "Approve" -- this is for recipes awaiting approval not the same as "Approved"
    }
    public void getDrafts(){
        //select all the recipe ids and names where the status is "Draft"
    }
    public void updateStatus(){ //parameters recipeID and String for status
        //update the status of the specified dish id to whatever the parameter is i.e. Review/Approve/Approved
    }
    public void addIngredient(){ //parameters list of strings ingredients and recipe id
        //insert ingredient(s) specified with the specified recipe id -- ensure status is draft
    }
    public void removeIngredient(){ //parameters list of strings ingredients and recipe id
        //delete the ingredient(s) specified from the specified recipe id
    }
}
