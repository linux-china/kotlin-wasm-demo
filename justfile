build:
  ./gradlew clean build

run:
  npx live-server --watch=build/bin/native,index.html