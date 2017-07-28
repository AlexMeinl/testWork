Ext.define('RestaurantCatalog.controller.RestaurantCatalogController', {
    extend: 'Ext.app.Controller',

    refs: [
        {selector: 'restaurantGridView',
            ref: 'restaurantGridView'},
        {selector: 'restaurantGridView button[action="add"]',
            ref: 'restaurantGridAdd'},
        {selector: 'restaurantGridView button[action="delete"]',
            ref: 'restaurantGridDelete'},
        {selector: 'searchRestaurantView button[action="search"]',
            ref: 'searchRestaurant'},
        {selector: 'addRestaurantFormView',
            ref: 'addRestaurantFormView'},
        {selector: 'restaurantCatalogView',
            ref: 'restaurantCatalogView'},
        {selector: 'addRestaurantFormView textfield[name=name] ',
            ref: 'addRestaurantFormName'},
        {selector: 'addRestaurantFormView textfield[name=price]',
            ref: 'addRestaurantFormPrice'},
        {selector: 'addRestaurantFormView button[action=save]',
            ref: 'addRestaurantFormSave'}
    ],

    init: function () {
        this.control({
            'restaurantGridView  button[action=add]': {
                click: this.onAddRestaurant
            },
            'restaurantGridView  button[action=delete]': {
                click: this.onDelRestaurant
            },
            'searchRestaurantView  textfield[name="search"]': {
                change: this.onChangeText
            },
            'restaurantGridView': {
                cellclick: this.onLineGrid
            },
            'addRestaurantFormView  button[action=save]': {
                click: this.onSaveRestaurant
            },
            'addRestaurantFormView  textfield[name=name]': {
                change: this.onValidation
            },
            'addRestaurantFormView  textfield[name=price]': {
                change: this.onValidation
            }
        });
    },

    onSaveRestaurant: function (button) {
        var me = this;
        var restaurantModel = Ext.create('RestaurantCatalog.model.RestaurantCatalogModel');
        restaurantModel.set(this.getAddRestaurantFormView().down('form').getValues());
        restaurantModel.save({
            success: function (operation, response) {
                var objAjax = operation.data;
                Ext.getStore('RestaurantCatalogStore').add(objAjax);
                me.getAddRestaurantFormView().close();
            },
            failure: function (dummy, result) {
                Ext.MessageBox.show({
                    title: 'Дубликат!',
                    msg: 'Такой ресторан уже существуют',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.ERROR
                });
            }

        });
    },

    onAddRestaurant: function () {
        Ext.widget('addRestaurantFormView');
    },

    onDelRestaurant: function () {
        var sm = this.getRestaurantGridView().getSelectionModel();
        var rs = sm.getSelection();
        this.getRestaurantGridView().store.remove(rs[0]);
        this.getRestaurantGridView().store.commitChanges();
        this.getRestaurantGridDelete().disable();
    },

    onChangeText: function () {
        Ext.getStore('RestaurantCatalogStore').load({
            params: {
                search: this.getRestaurantCatalogView().down('searchRestaurantView').getValues()
            }
        });
    },

    onLineGrid: function () {
        this.getRestaurantGridDelete().enable();
    },

    onValidation: function () {
        if (this.getAddRestaurantFormName().validate() && this.getAddRestaurantFormPrice().validate()) {
            this.getAddRestaurantFormSave().enable();
        } else {
            this.getAddRestaurantFormSave().disable();
        }
    }

});
