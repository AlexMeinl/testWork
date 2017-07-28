Ext.application({
    name: 'testWork',

    views: [
        'AddRestaurantFormView',
        'RestaurantCatalogView',
        'RestaurantGridView',
        'SearchRestaurantView'
    ],

    controllers: [
        'RestaurantCatalogController'
    ],

    stores: [
        'RestaurantCatalogStore'
    ],

    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype  : 'restaurantCatalogView'
            }
        });
    }
});



