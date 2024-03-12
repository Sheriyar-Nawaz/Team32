// Interface for communication between Kitchen and Management
    interface KitchenManagementSender {
        void sendMenu(Menu menu); //Menu has getDishes() -> Dish has getRecipes() -> Recipe has getIngredients()
    }
