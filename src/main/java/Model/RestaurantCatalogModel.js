Ext.define('RestaurantCatalog.model.RestaurantCatalogModel', {
    extend: 'Ext.data.Model',
    fields: ['name'],
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