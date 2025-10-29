# Changelog
All notable changes to CDL will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.6.0] - 2025-10-30

### Added
- **Complete Type System**: Type definitions with `type` keyword and field constraints
- **Built-in Types**: `string`, `int`, `decimal`, `bool`, `date`, `datetime`, `Email`, `Money`
- **Type Constraints**: `where` clauses with functions (`length()`, `contains()`, `today()`, etc.)
- **Typed Intent Parameters**: Strong typing for inputs/outputs instead of string metadata
- **Advanced Type Checker**: Circular reference detection, constraint validation, type resolution
- **Enhanced OpenAPI Generation**: Type-safe schemas with proper constraints and references
- **Extended CTK**: 10 comprehensive test cases covering all type system features
- **VS Code Extension Updates**: Enhanced syntax highlighting, IntelliSense snippets, hover tooltips
- **Code Coverage**: JaCoCo integration with coverage reporting
- **Quality Metrics**: CI/CD pipeline with automated testing and documentation deployment

### Changed
- **Intent Syntax**: Now supports typed parameters: `inputs: "[customer: Customer, amount: Money]"`
- **Type Validation**: Compile-time type checking with detailed error reporting
- **API Generation**: OpenAPI schemas now include type constraints and validations
- **Error Codes**: Extended error model (E001-E007) for comprehensive type checking

### Fixed
- Type reference resolution across complex type graphs
- Constraint validation for all built-in types
- Circular dependency detection in type definitions

## [0.5.0] - 2025-10-29

### Fixed
- N/A
