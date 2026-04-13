# StackDrops

A lightweight and reliable solution for handling stacked item drops in Minecraft 1.8.8 — without duplication bugs, inconsistent behavior, or broken inventory logic.

---

## ✨ Overview

**StackDrops** was built to solve a very specific (and very common) problem in legacy Minecraft servers:

> Item duplication and inconsistent pickup behavior caused by broken stack handling.

Many existing solutions (such as HeroStackDrops) rely on internal inventory methods like `Inventory#addItem()`, which are **unreliable in 1.8.8** and can lead to:

* Item duplication
* Item loss
* Incorrect stack calculations
* Inconsistent behavior depending on inventory state

This plugin replaces that behavior with a **fully controlled, deterministic stacking system**.

---

## ⚙️ How It Works

Instead of relying on Bukkit’s internal inventory logic, StackDrops:

* Stores the real stack amount using metadata
* Cancels the default pickup event
* Manually distributes items into the player inventory

### Pickup Logic

When a player picks up a stacked item:

1. Existing stacks are filled first (vanilla-like behavior)
2. Remaining items are distributed into empty slots
3. Any leftover stays on the ground and updates its display
4. If fully collected, the entity is removed

This ensures:

* ✔ No duplication
* ✔ No item loss
* ✔ Accurate stack handling
* ✔ Predictable behavior

---

## 🚫 Why Not `addItem()`?

Minecraft 1.8.8 has known issues with:

```java
Inventory#addItem()
```

It may:

* Add a different amount than expected
* Return incorrect leftovers
* Behave inconsistently depending on inventory contents

StackDrops avoids this entirely by implementing its own logic.

---

## 📦 Features

* Deterministic stack distribution
* Vanilla-like inventory merging
* Metadata-based stack tracking
* Safe handling of partial pickups
* Zero reliance on broken Bukkit methods

---

## 🧪 Compatibility

> ⚠ This plugin was **designed and tested exclusively for Minecraft 1.8.8**

* ✔ Spigot 1.8.8
* ✔ CraftBukkit 1.8.8
* ❌ Not tested on newer versions
* ❌ Not guaranteed to work outside 1.8

---

## 🛠 Build Instructions

### Requirements

* Java 8
* Maven
* Spigot 1.8.8 (installed locally)

### Step 1 — Install Spigot (Required)

Due to licensing, Spigot is not available in public Maven repositories.

Use **BuildTools**:

```bash
java -jar BuildTools.jar --rev 1.8.8
```

This installs the required dependencies into your local Maven repository.

---

### Step 2 — Build the Plugin

```bash
mvn clean package
```

The compiled JAR will be available in:

```
/target/stack-drops-1.0-SNAPSHOT.jar
```

---

## 📌 Notes

* This project intentionally avoids modern APIs to maintain full 1.8 compatibility
* Designed for performance and correctness over abstraction
* Ideal for legacy servers that still rely on 1.8 mechanics

---

## 🤝 Contributing

Contributions are welcome, but keep in mind:

* The target version is strictly **1.8.8**
* Avoid introducing APIs from newer versions
* Maintain deterministic behavior (no reliance on Bukkit internals)

---

## 📜 License

MIT License — feel free to use, modify, and integrate into your own projects.

---

## 💬 Final Thoughts

If you've ever dealt with broken stack plugins, ghost items, or duplication issues in 1.8…

This exists so you don’t have to anymore.
