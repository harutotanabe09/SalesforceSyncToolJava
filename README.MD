# Salesforce Api Tool
REST API client of salesroce for java11 

## Requirement

```
* Java11
* Git
```

```
$ git clone 
$ npm install
$ npm run build
```
### Output
```
/dist/kintone-js-sdk.min.js
/esm/browser/main.js
/cjs/node/main.js
```

# Installation
npm i @kintone/kintone-js-sdk

## Note
From v0.5.0 completely changed parameters of all modules' constructors and functions to single object parameters.
If you will not use v0.5.0 or upper, please specify the version to install.<br/>
Ex.
```
npm i @kintone/kintone-js-sdk@v0.4.2
```

# Usage
* UMD: include <i>kintone-js-sdk.min.js</i> from <i>dist</i> folder <br/>
```
const kintone = window.kintoneJSSDK;
```
* CommonJS: install kintone-js-sdk using "npm i @kintone/kintone-js-sdk"<br/>
```
const kintone = require('@kintone/kintone-js-sdk')
```
* ESM: install kintone-js-sdk using "npm i @kintone/kintone-js-sdk"<br/>
```
import * as kintoneJSSDK from '@kintone/kintone-js-sdk'
```


# Document
Github pages