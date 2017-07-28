Ext.define('testWork.view.RestaurantCatalogView', {
    extend: 'Ext.panel.Panel',
    width: 500,
    height: 360,
    padding: 10,
    alias: 'widget.restaurantCatalogView',
    layout: 'border',
    items: [
        {
            xtype: 'restaurantGridView',
            region: 'center'
        },
        {
            xtype: 'panel',
            html: '<div style="font: normal 18px cursive"><center><font size = "10">Рестораны</font></center></div>',
            region: 'north',
            height: 80
        },
        {
            xtype: 'searchRestaurantView',
            title: 'Поиск',
            region: 'west',
            width: 300,
            collapsible: true,
            collapsed: false
        }
    ],
    renderTo: Ext.getBody()
});
