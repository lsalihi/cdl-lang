# Contributing to CDL

Thank you for your interest in contributing to CDL! This document outlines the process for contributing.

## Development Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/lsalihi/cdl-lang.git
   cd cdl-lang
   ```

2. Build the project:
   ```bash
   ./gradlew build
   ```

3. Run tests:
   ```bash
   ./test_ctk.sh
   ```

4. Run demo:
   ```bash
   ./demo.sh
   ```

## Development Workflow

1. Create a feature branch from `master`
2. Make your changes
3. Run tests: `./test_ctk.sh`
4. Format code: `./gradlew spotlessApply` (if configured)
5. Commit with clear messages
6. Push and create a Pull Request

## Pull Request Guidelines

- Follow the existing code style
- Update documentation if needed
- Add tests for new features
- Ensure CI passes
- Use conventional commit messages

## Code Style

- Java: Follow Google Java Style Guide
- Documentation: Clear, concise, and complete
- Commit messages: Use conventional commits

## Testing

- Run `./test_ctk.sh` to verify backends
- Add new test cases to `ctk/` directory
- Ensure new features are tested

## Questions?

Open an issue or discussion on GitHub.
