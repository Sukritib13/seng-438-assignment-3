**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#: 16   |     |
| -------------- | --- |
| Student Names: |     |
|                |     |
|                |     |
|                |     |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

Text…

# 2 Manual data-flow coverage calculations for X and Y methods

Text…

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text…

# 6 Pros and Cons of coverage tools used and Metrics you report

In our assignment, we used EclEmma as our code coverage tool. It was selected because of its smooth Eclipse integration, which makes it simple to use and set up. Although EclEmma did not offer condition coverage, it did enable us to measure statement, branch, and method coverage. Its visual feedback technique, which displayed uncovered code in red and covered code in green, was one of its most helpful features. Because of this, it was simpler to find areas where our test coverage was lacking and adjust our unit tests appropriately. We were also able to keep the majority of our initial tests while performing white-box testing to increase coverage because EclEmma was compatible with mock objects.

However, EclEmma had some limitations. One major drawback was that it did not support condition coverage, which would have allowed us to analyze individual Boolean subconditions within decision statements. Additionally, the tool did not account for dead or unreachable code, which affected our overall coverage percentage. For example, in the DataUtilities class, our statement coverage was 89.6% instead of reaching 90% because EclEmma still considered logically unreachable code in its calculations.

In terms of reported metrics, we primarily focused on statement coverage (percentage of executed statements), branch coverage (percentage of executed control flow branches), and method coverage (percentage of methods executed at least once). These metrics helped us assess test effectiveness and guided improvements in our testing approach. Despite its limitations, EclEmma was a valuable tool for evaluating and improving our test coverage.

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
