# Brace Matching

Write a program that returns a `boolean` telling if a string contains all matching braces.

## Assumptions

* The string will only contain `()[]{}<>`.
* There will be no bad characters
* There are the following helper methods
  * `start?(c)` returning `true` if a character is one of `([{<`
  * `closing(c)` returning `)]}>` respective to the parameter passed

## Expected Results

| `true` | `false` |
| ------ | ------- |
|        | `][`    |
| `()`   | `[(]`   |
| `[()]` | `[](>`  |
| `()[]` | `[[]]]` |
| `<()>[]` | `<`   |
| `(()())` |  `<)` |

## Variants

Do it both iteratively and recursively.
