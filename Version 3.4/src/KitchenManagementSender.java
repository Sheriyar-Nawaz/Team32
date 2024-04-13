// Interface for communication between Kitchen and Management
    interface KitchenManagementSender {
        void sendMenu(MenuCompGUI menu); //Menu has getDishes() -> Dish has getRecipes() -> Recipe has getIngredients()
    }
