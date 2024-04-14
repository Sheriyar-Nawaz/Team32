public class RecipesDB {

    public void getReviews(){
        //select all the recipe ids and names where the status is "Review"
    }
    public void getApproves(){
        //select all the recipe ids and names where the status is "Approve" -- this is for recipes awaiting approval not the same as "Approved"
    }
    public void getRecipes(){
        //select all the recipe ids and names
    }
    public void getRecipeIngredients(){ //parameter recipe id
        //select ingredients ids and names where the recipe id is same as parameter
    }
    public void getIngredients(){
        //select all ingredients
        //more code will be needed to make sure its only available ingredients
    }
    public void getStatus(){ //parameter recipe id
        //select the status based off a recipe id
    }
    public void updateStatus(){ //parameters recipeID and String for status
        //update the status of the specified dish id to whatever the parameter is i.e. Review/Approve/Approved
    }
    public void addIngredient(){ //parameters list of strings ingredients and recipe id
        //insert ingredient(s) specified with the specified recipe id -- ensure status is draft, if it's not -- duplicate recipe details with status changed to draft
    }
    public void addQuantity(){ //parameters double quantity, ingredient id and recipe id
        //insert quantity specified for the ingredient with the specified recipe id
    }
    public void addDescription(){ //parameters String description and recipe id
        //insert description to the id specified
    }
    public void removeIngredient(){ //parameters list of strings ingredients and recipe id
        //delete the ingredient(s) specified from the specified recipe id
    }
}
