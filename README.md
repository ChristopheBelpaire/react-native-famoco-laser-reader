# react-native-famoco-laser-reader

## Getting started

`$ npm install react-native-famoco-laser-reader --save`

### Mostly automatic installation

`$ react-native link react-native-famoco-laser-reader`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-famoco-laser-reader` and add `FamocoLaserReader.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libFamocoLaserReader.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.FamocoLaserReaderPackage;` to the imports at the top of the file
  - Add `new FamocoLaserReaderPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-famoco-laser-reader'
  	project(':react-native-famoco-laser-reader').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-famoco-laser-reader/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-famoco-laser-reader')
  	```


## Usage
```javascript
import FamocoLaserReader from 'react-native-famoco-laser-reader';

// TODO: What to do with the module?
FamocoLaserReader;
```
