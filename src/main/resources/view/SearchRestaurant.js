Ext.define('testWork.view.SearchRestaurant', {
    extend: 'Ext.form.Panel',
    alias: 'widget.searchRestaurantView',
    bodyPadding: 10,
    items: [
        {
            xtype: 'textfield',
            name: 'search',
            fieldLabel: 'Введите название ресторана',
            maxLength: 200
        }
    ]
});
