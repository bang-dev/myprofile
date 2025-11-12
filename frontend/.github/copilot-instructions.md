<!-- .github/copilot-instructions.md - Project-specific guidance for AI coding agents -->
# Copilot instructions — frontend (Vite + React)

Summary
- Small single-page React app scaffolded with Vite. Uses React 19, the React Compiler via a Babel plugin, and a custom `vite` override to `rolldown-vite`.

Quick commands (PowerShell)
```
npm install
npm run dev        # start vite dev server with HMR
npm run build      # production build
npm run preview    # serve the build locally
npm run lint       # run ESLint using project's `eslint.config.js`
```

Key files to read first
- `package.json` — scripts, React versions, and the `vite` override (`npm:rolldown-vite@7.2.2`).
- `vite.config.js` — Vite plugins configuration; React Compiler enabled via `babel-plugin-react-compiler`.
- `eslint.config.js` — project lint rules; note `no-unused-vars` allows names matching `^[A-Z_]`.
- `index.html` — root HTML, imports `/src/main.jsx` and uses `/vite.svg` from `public/`.
- `src/main.jsx`, `src/App.jsx`, `src/Message.jsx` — primary React entry and components (Message.jsx is currently empty).

Architecture & conventions (what matters)
- Single-page Vite + React app. Entry point is `src/main.jsx` which mounts `<App />` into `#root` in `index.html`.
- Components live under `src/` as `.jsx` files. Import static assets directly (example: `import reactLogo from './assets/react.svg'`) and reference public assets with absolute paths like `/vite.svg`.
- The project uses the React Compiler (fast-refresh tooling) by configuring a Babel plugin inside `vite.config.js`. This affects local dev/build performance — prefer small, focused edits when iterating.
- `package.json` sets `"type": "module"` — ES module semantics apply; use `import`/`export` style.

Dependency & integration notes
- `vite` is overridden to `rolldown-vite@7.2.2` (see `package.json` `devDependencies` and `overrides`). Avoid changing Vite packaging without verifying why this override exists.
- React is at v19; the repo expects modern JSX/runtime behavior.
- ESLint is configured via `eslint.config.js` (config-as-code style). `npm run lint` uses that config; CI (if added) will likely run the same command.

Developer workflow expectations
- Local dev: run `npm install` once, then `npm run dev`. HMR is enabled; edit `src/App.jsx` or components to test changes.
- Before opening a PR: run `npm run lint` and `npm run build` locally to catch obvious issues.
- There are no tests in this scaffold; if you add tests, place them next to components or in a `__tests__` folder.

What to watch out for (common pitfalls)
- Performance impact: the React Compiler plugin is enabled; large rebuilds can be slower. For large refactors consider temporarily disabling the compiler if iteration speed is important, but first discuss why (the compiler was intentionally enabled).
- Package override: upgrading `vite` must consider the `rolldown-vite` override — treat it as an explicit choice.
- Naming & lint rule: `eslint.config.js` ignores unused vars that match `^[A-Z_]`. This pattern is used to keep some globals or constants without lint noise.

Examples (from repo)
- Entry: `src/main.jsx` mounts `App` into `#root` in `index.html`.
- Component: `src/App.jsx` imports `./App.css`, `src/assets/react.svg` and `/vite.svg` (public)
- Empty placeholder: `src/Message.jsx` exists but is empty — a sensible place to implement messaging UI.

If you change files
- Run `npm run lint` and `npm run build` locally. If you change `vite` or its plugins, verify dev and build both start successfully.

Questions for the repo owner
- Is the `rolldown-vite` override required for a specific platform or performance reason? Mentioning rationale in README would help future contributors.
- Any CI checks (lint/build/test) we should run as part of PR validation? If so, add the commands here.

If any section needs more detail or you want this file to include PR/commit templates and CI steps, tell me what to include and I will update it.
