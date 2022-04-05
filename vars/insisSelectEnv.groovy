#!/usr/bin/env groovy
import insisEnv

def call(selectedEnvironment){
echo "Selected environment: ${selectedEnvironment}"
def insisEnv = new insisEnv()

def resultMap = [:]

    switch(selectedEnvironment) {
    case insisEnv.INSIS_ENV_1:
        resultMap.WL_HOST = insisEnv.INSIS_HOST_1
        resultMap.target_domain = "devdomain"
        break
    case insisEnv.INSIS_ENV_2:
        resultMap.WL_HOST = insisEnv.INSIS_HOST_2
        resultMap.target_domain = "testdomain"
        break
    }
echo "Selected environment details: ${resultMap}"
     return resultMap
}