## Parameters for Initiate Order

Parameters with **`*`** are the mandatory fields to be filled.

**merchantOrderId`*`** : Required (Data type: string): The unique merchant order id from the merchant side - Should be Between 1 and 45 characters.

**language** : Optional (Data type: string): Default is set to English if not passed, supported languages en for English or ar for Arabic - Limited to 2 characters.

**merchantBranch** : Optional (Data type: string): in case the merchant has multiple branches you can pass the branch of the order by default "main".

**subTotal`*`** : Required (Data type: double): basket amount  `<double>` three decimals format.

**totalAmount`*`** : Required (Data type: double): Total amount to be charged to the customer, including the discounts & taxes & delivery fees`<double>` three decimals format.

**currency`*`** : Required (Data type: string): The three-letter ISO currency code e.g KWD or SAR - Should be of 3 characters.

**discountAmount`*`** : Required (Data type: double) You can pass it as "0" for no discount.

**taxAmount`*`** : Required (Data type: double): you can pass it as "0" if the taxes are not applied in your country.

**deliveryAmount`*`** : Required (Data type: double): you can pass it as "0" if there are no delivery fees.

**deliveryMethod`*`** : Required (Data type: string): home delivery or pickup or email delivery for digital products - Should be Between 3 and 45 characters.

**otherFee** : Optional (Data type: double): you can pass it as null

**isDigitalOrder** : Optional (Data type: boolean): by default is false, if the order type is digital order then pass it true so the delivery_address is not required.

**merchantRedirectUrl`*`** :

-Required (Data type: string):

-if the Payment status is "confirmed".redirection usually leads to the "Thank you" page with the order details provided.

-if the Payment status is "rejected". Redirection also often leads to the checkout or cart page, but requires the general Rejection Message on checkout "Sorry, we are unable to process your payment. Please try again or select another payment method".

-if the Payment status is "cancel" . redirection may lead back to the checkout or cart page and show message below as customers cancel.

-Limited to 255 characters.

**platform** : Required (Data type: string): for direct integration through our APIs then the platform will be website for the plugins send the plugin name e.g WooCommerce - shopify - magento ...etc - Should be Between 5 and 65 characters.

**isMobile** : Optional (Data type: boolean): for mobile integrations send true, by default false (max 64 characters).

**postBackUrl** : Optional (Data type: string): URL of the webhook URL - Limited to 255 characters.

**merchantLogo** : Optional (Data type: string): URL of the sub-merchant logo (max 256 characters) logo dimension must be 250px x 250px - Limited to 255 characters.


**PSP** : 

* **isPspOrder** : Optional (Data type: boolean): required Only applicable for B2B merchants / by default false.

* **pspProvider** : Optional (Data type: string): if it's false then you can send null, if it's true then send your provider name e.g. tap - Limited to 30 characters.

* **subMerchantId** : Optional (Data type: Int): default value is null

* **subMerchantName** : Optional (Data type: string): default value is null - Limited to 35 characters.

**orderItems`*`** :

* **sku`*`** : Required (Data type: string): item SKU double or id - Should be Between 1 and 125 characters.

* **type** : Optional (Data type: string): The type of the product e.g physical, digital etc. by default physical - Limited to 125 characters.

* **name`*`** : Required (Data type: string): item name - Should be Between 1 and 255 characters.

* **currency`*`** : Required (Data type: string): The three-letter ISO currency code e.g KWD or SAR - Should be of 3 characters.

* **itemDescription** : Optional (Data type: string): item name - description of the item - Limited to 255 characters.

* **quantity`*`** : Required (Data type: int): the ordered quantity of the item.

* **itemPrice`*`** : Required (Data type: double): the ordered price of the item.

* **imageUrl** : Optional (Data type: string): URL to an image of the item - recommended image resolution 1024 width X 1024 height - Limited to 255 characters.

* **itemUrl** : Optional (Data type: string): URL of the item - Limited to 255 characters.

* **itemUnit** : Optional (Data type: string): Unit used to describe the quantity, e.g. kg, pcs, etc - Limited to 25 characters.

* **itemSize** : Optional (Data type: string): the size/weight of the item - Limited to 125 characters.

* **itemColor** : Optional (Data type: string): the color of the item - Limited to 25 characters.

* **itemGender** : Optional (Data type: string): the item made for men only, women, kids, pets, other - Limited to 25 characters.

* **itemBrand** : Optional (Data type: string): the brand of the item - Limited to 125 characters.

* **itemCategory** : Optional (Data type: string): The item's category path as used in the merchant's webshop. Include the full and most detailed category and separate the segments with ' > ' - Limited to 25 characters.

**customerDetails`*`** : 

* **firstName** : Optional (Data type: string): default value is null - Limited to 100 characters.

* **lastName** : Optional (Data type: string): default value is null - Limited to 100 characters.

* **gender** : Optional (Data type: string): default value is null - Limited to 7 characters.

* **phoneNumber** : Optional (Data type: string) - Limited to 12 characters.

* **customerEmail** : Optional (Data type: string): default value is null - Limited to 100 characters.

* **registeredSince** : Optional (Data type: string): time the customer account created in your website in UTC in iso 8601 date/time  default value is null.
Date Format :- yyyy-mm-dd

* **loyaltyMember** : Optional (Data type: boolean): default null.

* **loyaltyLevel** : Optional (Data type: string): default null - Limited to 25 characters.


**deliveryAddress`*`** : If the delivery is over the email for the digital orders then you can pass the deliveryAddress as null.

* **city** : Optional (Data type: string): default value is null - Limited to 40 characters.

* **area** : Optional (Data type: string): default value is null - Limited to 40 characters.

* **fullAddress** : Optional (Data type: string): default value is null - Limited to 255 characters.

* **phoneNumber** : Optional (Data type: string): default value is null - Limited to 13 characters.

* **customerEmail** : Optional (Data type: string): default value is null - Limited to 100 characters.

    ```
    {
      "currency": "KWD",
      "customerDetails": {
        "customerEmail": null,
        "firstName": null,
        "gender": null,
        "lastName": null,
        "loyaltyLevel": null,
        "loyaltyMember": false,
        "phoneNumber": null,
        "registeredSince": null
      },
      "deliveryAddress": {
        "area": null,
        "city": null,
        "customerEmail": null,
        "fullAddress": null,
        "phoneNumber": null
      },
      "deliveryAmount": 0.0,
      "deliveryMethod": "home delivery",
      "discountAmount": 0.0,
      "isDigitalOrder": false,
      "isMobile": true,
      "language": "en",
      "merchantBranch": "main",
      "merchantLogo": null,
      "merchantOrderId": "1693206151716",
      "merchantRedirectUrl": "https://yourmerchant.com/checkout/",
      "orderItems": [
        {
          "currency": "KWD",
          "imageUrl": null,
          "itemBrand": null,
          "itemCategory": null,
          "itemColor": null,
          "itemDescription": null,
          "itemGender": null,
          "itemPrice": 1.0,
          "itemSize": null,
          "itemUnit": null,
          "itemUrl": null,
          "name": "Blue shirt 998",
          "quantity": 1,
          "sku": "23433312436",
          "type": "physical"
        }
      ],
      "otherFee": null,
      "platform": "Android",
      "postBackUrl": null,
      "PSP": {
        "isPspOrder": false,
        "pspProvider": null,
        "subMerchantId": null,
        "subMerchantName": null
      },
      "subTotal": 1.0,
      "taxAmount": 0.0,
      "totalAmount": 1.0
    }
    ```