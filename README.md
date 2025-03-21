# LeetCode Solutions Repository

This repository contains my LeetCode solutions and a Chrome extension for automatically syncing LeetCode submissions to GitHub.

## Repository Structure

- **`/leetcode-ext/`**: Chrome extension for automatically syncing LeetCode submissions to GitHub
- **`/leetcode-sub/`**: Directory containing all my LeetCode problem solutions

## LeetCode Extension

The Chrome extension automatically syncs your LeetCode submissions to GitHub. See the [extension README](/leetcode-ext/README.md) for more details on installation and usage.

### Installing the Extension

1. Open Chrome and navigate to `chrome://extensions/`
2. Enable "Developer mode" (toggle in the top-right corner)
3. Click "Load unpacked" and select the `/leetcode-ext/` directory
4. The extension icon will appear in your browser toolbar

## LeetCode Submissions

The `/leetcode-sub/` directory contains all my LeetCode problem solutions, organized by problem number and name.

## Getting Started

1. Clone this repository
2. Install the Chrome extension from the `/leetcode-ext/` directory
3. Configure the extension to sync submissions to the `/leetcode-sub/` directory
4. Start solving problems on LeetCode - your solutions will be automatically synced!

## Security

This extension uses GitHub OAuth for authentication. The OAuth credentials are stored locally and all communication happens directly between your browser and GitHub's servers. No third-party servers are involved in the authentication process.

## License

MIT

This project is licensed under the MIT License - see the LICENSE file for details.
