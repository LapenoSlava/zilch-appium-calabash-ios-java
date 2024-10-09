To launch tests you need to:
1. Add iOS app to apps/ folder in the root folder of project
2. Register an accont on [habitica](https://habitica.com/static/home) and add these credentials to /resources/user.properties file in a format:
email=email
password=password
userName=username
3. Launch server: appium --base-path /wd/hub
4. Run tests: mvn clean install
