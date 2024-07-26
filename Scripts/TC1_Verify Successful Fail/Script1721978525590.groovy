import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utils.testLogin as TestLogin

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com')

WebUI.switchToWindowTitle('CURA Healthcare Service')

WebUI.click(findTestObject('Object Repository/Login_page/Page_CURA Healthcare Service/a_CURA Healthcare_menu-toggle'))

WebUI.click(findTestObject('Object Repository/Login_page/Page_CURA Healthcare Service/a_Login'))

WebUI.setText(findTestObject('Object Repository/Login_page/Page_CURA Healthcare Service/input_Username_username'), 'test')

WebUI.setEncryptedText(findTestObject('Object Repository/Login_page/Page_CURA Healthcare Service/input_Password_password'), 
    'P9ET2sDE0SE=')

WebUI.click(findTestObject('Object Repository/Login_page/Page_CURA Healthcare Service/button_Login'))

WebUI.acceptAlert()

WebUI.verifyElementText(findTestObject('Object Repository/Login_page/Page_CURA Healthcare Service/p_Login failed Please ensure the username a_eb55b5'), 
    'Login failed! Please ensure the username and password are valid.')

WebUI.acceptAlert()

WebUI.getNumberOfTotalOption(findTestObject(null))

// Define the test data
def data = findTestData('/Users/viji/Desktop/SuiteAnalysis.xlsx')

// Loop through the data rows
for (int i = 1; i <= data.getRowNumbers(); i++) {
    // Retrieve data from the file
    def username = data.getValue('username', i)

    def password = data.getValue('password', i)

    // Use the data in your test steps
    WebUI.setText(findTestObject('Page_Login/input_Username'), username)

    WebUI.setText(findTestObject('Page_Login/input_Password'), password)

    WebUI.click(findTestObject('Page_Login/button_Login'))

    // Add assertions or other test steps
    WebUI.verifyElementPresent(findTestObject('Page_Home/label_Welcome'), 10)
}


