# Alura Course Clean Architecture

## Patterns

#### Entity

- [x] When you class have some kind of "identification" like id or cpf. So you have how diff two or more 
objects based in one or more attributes;

#### Value Object [Article Uncle Bob About It](https://martinfowler.com/bliki/ValueObject.html)

- [x] When your class have not how difference their own objects;
- [x] The interest is about some value;
- [x] Value objects should be immutable;
- [x] If equality between two objects of a class is verified by comparing all their values, it is a Value Object.

## Architecture Conceps

### Layers

- [x] Our application only depends on our domain, and does not recognize infrastructure details. The infrastructure layer supports the innermost layers.
- [x] Domain layer must be the focus;
- [x] Web, frameworks, persistence mechanism of data are just details.