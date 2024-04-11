// Interface for communication between Kitchen and Management
    interface KitchenManagementSender {
        void sendMenu(MenuGUI menu); //Menu has getDishes() -> Dish has getRecipes() -> Recipe has getIngredients()
    }
