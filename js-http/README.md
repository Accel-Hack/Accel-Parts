# Common package for Typescript/Javascript

* [npm repository](https://github.com/Accel-Hack/Accel-Parts/pkgs/npm/accel-parts-http)
* 参考文献
    * [【TypeScript】Githubにprivateのnpmパッケージを公開する方法を解説](https://marsquai.com/745ca65e-e38b-4a8e-8d59-55421be50f7e/1f67fdab-8e00-4ae1-a1b9-077d5a30a5d6/1f5f0d50-0620-429d-9cd4-63f1bacf52fd/)

## How to publish
0. create `.npmrc` file
   1. ```
      //npm.pkg.github.com/:_authToken=<GITHUB_TOKEN>
      @accelhack:registry=https://npm.pkg.github.com/
      ```
1. run `npm run publish`


## How to install
1. add dependencies
   * `"@lacicu/web-common": "version(ex 0.9.0)"` in package.json 
2. run `npm install`