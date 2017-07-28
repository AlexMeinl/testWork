Ext.define('RestaurantCatalog.store.RestaurantCatalogStore', {
    extend: 'Ext.data.Store',
    requires : [
        'RestaurantCatalog.model.RestaurantCatalogModel'
    ],
    model: 'RestaurantCatalog.model.RestaurantCatalogModel',
    autoLoad: true,
    autoSync: true,
    proxy: {
        type: 'rest',
        api: {
            create: 'restaurant',
            read: 'restaurant',
            destroy: 'restaurant',
            update: 'restaurant'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }

    }
});
