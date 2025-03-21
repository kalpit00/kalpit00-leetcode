# LeetCode Tracker Extension

## Overview

LeetCode Tracker is a Chrome extension that automatically syncs your LeetCode submissions to GitHub. When you successfully solve a problem on LeetCode, the extension captures your solution and commits it to your specified GitHub repository.

## Features

- **Automatic Syncing**: No manual copying and committing required
- **Organization by Problem**: Solutions are organized by problem number and difficulty
- **Progress Tracking**: View your progress directly in the extension
- **Secure Authentication**: Uses GitHub OAuth for secure authentication
- **Privacy-Focused**: All operations happen in your browser - no third-party servers involved

## Installation

### Local Installation

1. Navigate to `chrome://extensions/` in Chrome
2. Enable "Developer mode" by toggling the switch in the top-right corner
3. Click "Load unpacked"
4. Select the `/leetcode-ext/` directory from this repository

## Setup

1. After installation, click on the extension icon in your browser toolbar
2. Click the "Authenticate" button to connect your GitHub account
3. Select the repository where you want to store your LeetCode solutions
4. Start solving problems on LeetCode!

## How It Works

1. The extension monitors your LeetCode submissions
2. When you successfully solve a problem, it captures your solution
3. It then commits the solution to your GitHub repository
4. Solutions are organized by problem number and difficulty

## Security and Privacy

- **GitHub Authentication**: Uses OAuth for secure authentication
- **Local Storage**: Your credentials are stored locally in your browser
- **Direct Communication**: All API calls go directly from your browser to GitHub
- **Minimal Permissions**: Only requests access to what it needs

## Troubleshooting

- **Authentication Issues**: If you encounter authentication problems, try removing the extension and reinstalling it
- **Submission Not Syncing**: Make sure you've successfully passed all test cases on LeetCode
- **Repository Access**: Ensure the extension has permission to access your repository

## Development

This extension uses GitHub OAuth for authentication. The OAuth credentials are stored in the `environment.js` file. If you want to modify the extension, you'll need to:

1. Create your own GitHub OAuth application
2. Update the `CLIENT_ID` and `CLIENT_SECRET` in `environment.js`

```javascript
export const ENV = {
  URL: "https://github.com/login/oauth/authorize",
  ACCESS_TOKEN_URL: "https://github.com/login/oauth/access_token",
  REDIRECT_URL: "https://github.com/",
  REPOSITORY_URL: "https://api.github.com/repos/",
  USER_INFO_URL: "https://api.github.com/user",
  CLIENT_SECRET: "YOUR_CLIENT_SECRET_KEY",
  CLIENT_ID: "YOUR_CLIENT_ID",
  SCOPES: ["repo"],
  HEADER: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
};
```

## License

MIT
