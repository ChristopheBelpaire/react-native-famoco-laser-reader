import { NativeModules } from 'react-native';

const { FamocoLaserReader } = NativeModules;


class ReactNativeFamocoLaserReader {
    startReader() {
        return new Promise((resolve, reject) => {
            FamocoLaserReader.startReader(
                (err, result) => {
                    if (err) {
                        reject(err)
                    } else {
                        resolve(result)
                    }
                })
        })
    }

    stopReader() {
        FamocoLaserReader.stopReader()
    }
}

export default reactNativeFamocoLaserReader = new ReactNativeFamocoLaserReader()