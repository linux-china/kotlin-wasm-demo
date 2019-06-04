build:
  ./gradlew build

run:
  npx live-server --watch=build/bin/native,index.html