# Use Git

Open a command window and run:

```sh
$ git clone https://github.com/Alioshka/appium-maven-surefire-plugin-testng.git
```

# Start Appium

Open a command window and run:

```sh
$ appium
```
or

```sh
$ appium -p 4444
```
to specify a port to use

# Use Maven

Open a command window from the project root directory and run:
```sh
$ mvn clean test
```

You can specify your driver type and appium/grid url:
```sh
$ mvn clean test -Ddriver.type=Firefox
```
or
```sh
$ mvn clean test -Ddriver.type=AndroidChrome -Dappium.url=http://127.0.0.1:4444/wd/hub
```

You can specify your driver type, appium/grid url and what tests to run:
```sh
$ mvn clean test -Ddriver.type=Android -Dappium.url=http://127.0.0.1:4444/wd/hub -Dtestng.xml=resources/testng/android.xml
```

By default in pom.xml -Ddriver.type=Chrome -Dappium.url=http://127.0.0.1:4723/wd/hub -Dtestng.xml=resources/testng/web.xml
and your tests will run in desktop chrome


  - -Ddriver.type=Chrome - will run tests in desktop Chrome
  - -Ddriver.type=Firefox - will run tests in desktop Firefox
  - -Ddriver.type=AndroidChrome - will run tests in Android Chrome on real Android device(don't forget to connect your Android device through USB)
  - -Ddriver.type=iOSSafari - will run tests in iOS Safari on iOS Simulator
  - -Ddriver.type=Android - will run tests for your application on real Android device(don't forget to connect your Android device through USB)
  - -Ddriver.type=iOS - will run tests for your application on iOS Simulator


  - -Dappium.url=http://url_where_you_running_appium:port/wd/hub


  - -Dtestng.xml=resources/testng/your_tests_suit.xml


# Use

resources/capabilities/..._Capabilities.prorerties to specify a correct capabilities for you application and device where tests will be run

# Use

```sh
$ mvn clean test
```
instead of
```sh
$ mvn test
```
every time you run tests - the ReportNG html report was created(with screenshots),
so "clean" goal  deleting "target" folder where report created

# ReportNG HTML test report:

from the project root directory go to:
target/test-output/html/index.html

