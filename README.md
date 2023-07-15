<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
<div align="center">
<h2 align="center">QA Guru UI Autotest</h2>
  <p align="center">
    Java / Maven / Junit4 / Selenium / Allure-report
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>

  </ol>
</details>

<!-- ABOUT THE PROJECT -->


**QA task for User Interface**

This is a dedicated site for testing - https://qahacking.guru/index.php/magazin
You should develop autotests for the product catalog page.
Here the user can order the product.

**It is important for the user to be able to:**

1) select products,
2) change the quantity,
3) know the exact amount of the order.

**Test analyses:**

- User can select 1 of 4 products by two ways:

1) using Product Catalog Page and click to the Buy button
2) using Product Description Page and click to the Basket button

- User can change product quantity by two ways:

1) change default quantity = 1 to another digit on the Product Catalog Page and click Buy button
2) change quantity to another amount on the Basket Page and click Renew Basket Button

- User can check exact amount of the order in DogCoin:
  a) on Basket Page in Sum line (without delivery price)
  b) on the Order Page after fill all fields about user (include delivery price)

Test need to cover all variants 1 + 1 + a, 1 + 2 + a, 2 + 1 + a, 2 + 2 + a.
Variant b) is not considered here.
Basket page need to have Return Button.
Click to Return Button show again Product Catalog Page.
Condition of safety for Basket data when go back to Basket Page.


### Built With

* <a href="https://www.java.com/ru/">Java 11</a>
* <a href="https://mvnrepository.com/">Maven</a>
* <a href="https://junit.org/junit5/docs/current/user-guide/">Junit 4</a>
* <a href="https://www.selenium.dev/">Selenium</a>
* <a href="https://github.com/allure-framework/">Allure Framework</a>







