# Terminal Mastery for Java Developers

Learning Java through the CLI is powerful, but it can be repetitive. Use these tips to work faster and focus on the code.

## 1. The "Rapid Iterate" Loop
When you are fixing a bug or experimenting, you often run the same two commands: compile and run.

### The `&&` Operator
Chain them together. If compilation fails, the run command won't execute.
```bash
javac -d bin 01-virtual-threads/src/Step1Basic.java && java -cp bin Step1Basic
```

### The `!!` Command (Bang-Bang)
Run the exact last command again.
```bash
# You just ran the long command above
!! 
# Executes it again immediately
```

## 2. Searching History
Don't use the arrow keys to find a command from 10 minutes ago.

### Reverse Search (`Ctrl + R`)
1. Press `Ctrl + R`.
2. Type a part of the command (e.g., `Step4`).
3. Press `Enter` to run it, or `Ctrl + R` again to see older matches.

### The `!` Search
Run the most recent command that starts with a specific string.
```bash
!javac  # Runs the last javac command
!java   # Runs the last java command
```

## 3. Directory Navigation
If you are deep in a source folder, use these to get back.

- `cd -` : Switch back to the previous directory you were in.
- `cd ..` : Go up one level.

## 4. Multi-line Commands
For long classpaths or many source files, use the backslash `\` to break the command into multiple lines for readability.

```bash
javac -d bin \
  01-virtual-threads/src/Step1Basic.java \
  01-virtual-threads/src/Step2Scalability.java
```

## 5. Aliases (Pro Tip)
If you find yourself typing `javac -d bin` constantly, add an alias to your `~/.bashrc` or `~/.zshrc`:

```bash
alias jc='javac -d bin'
alias jr='java -cp bin'
```
Then you can just do: `jc src/File.java && jr File`
