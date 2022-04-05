import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification

class insisSelectEnvSpec extends JenkinsPipelineSpecification {
    def insisSelectEnv = null
    
    def resultMap = null

    def setup() {
        insisSelectEnv = loadPipelineScriptForTest("vars/insisSelectEnv.groovy")
        
    }

    def "[insisSelectEnv] will select the devdomain if case is INSIS_ENV_1"() {
        when:
            resultMap = insisSelectEnv "Dev (SE)"
        then:
            !resultMap.empty
            resultMap.WL_HOST == "dtopc101vm01.ocac.cloud.test.group"
            resultMap.target_domain == "devdomain"
    }

    def "[insisSelectEnv] will select the testdomain if case is INSIS_ENV_2"() {
        when:
            resultMap = insisSelectEnv "SE Code (Prod support)"
        then:
            !resultMap.empty
            resultMap.WL_HOST == "dtopc102vm01.ocac.cloud.test.group"
            resultMap.target_domain == "testdomain"
    }

    
}
