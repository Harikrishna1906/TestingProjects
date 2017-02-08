@Test
public void registerTest() {

driver.findElement(By.linkText("REGISTER")).click();

driver.findElement(By.name("firstName")).sendKeys("test");

driver.findElement(By.name("lastName")).sendKeys("test123`");

driver.findElement(By.name("phone")).sendKeys("68738686785");

driver.findElement(By.id("userName")).sendKeys("test@gmail.com");

driver.findElement(By.name("address1")).sendKeys("klsdflks");

driver.findElement(By.name("address2")).sendKeys("gmldkg");

driver.findElement(By.name("city")).sendKeys("dfgsl");

driver.findElement(By.name("state")).sendKeys("dglkdl");

driver.findElement(By.name("postalCode")).sendKeys("kdlfml");

String status = "false";

Select select = new Select(driver.findElement(By.name("country")));

List<WebElement> options = select.getOptions();

int optionsCount = options.size();

Reporter.log("Options Count" + optionsCount);

if (optionsCount > 0) {

for (WebElement option : options) {

Reporter.log("Available Options In dropDown "
+ option.getText());

if (option.getText().equals("INDIA")) {

select.selectByVisibleText("INDIA");
Reporter.log("Option with 'INDIA' is available in Dropdown");
status = "true";
break;
}
}
if (!(status == "true")) {
Reporter.log("Option with ' INDIA ' is  not available in Dropdown");
}
} else {
Reporter.log("There were no options available in Dropdown");
}

driver.findElement(By.id("email")).sendKeys("test123");

driver.findElement(By.name("password")).sendKeys("test123");

driver.findElement(By.name("confirmPassword")).sendKeys("test123");

driver.findElement(By.name("register")).click();

}
