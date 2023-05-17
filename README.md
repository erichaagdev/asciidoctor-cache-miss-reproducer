Steps to reproduce:

1. Download the [Gradle Enterprise Build Validation Scripts for Gradle](https://github.com/gradle/gradle-enterprise-build-validation-scripts/blob/a36f8294099f35367eba251c77007b65bf4c8acf/Gradle.md#installation):

```shell
curl -s -L -O https://github.com/gradle/gradle-enterprise-build-validation-scripts/releases/download/v2.4/gradle-enterprise-gradle-build-validation-2.4.zip && unzip -q -o gradle-enterprise-gradle-build-validation-2.4.zip
```

2. Run the following command:

```shell
./03-validate-local-build-caching-different-locations.sh \
  -r https://github.com/erichaagdev/asciidoctor-cache-miss-reproducer \
  -t asciidoctor
```