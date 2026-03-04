#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

    std::string s;
    std::cin >> s;

    int n;
    std::cin >> n;

    if (s.empty()) return;

    bool used[26] = { false };
    std::string ans = "";

    char prev = std::tolower((unsigned char)s[0]);
    int count = 1;

    for (int i = 1; i < s.size(); i++) {
        char curr = std::tolower((unsigned char)s[i]);

        if (curr == prev) {
            count++;
        }
        else {
            int idx = prev - 'a';

            if (0 <= idx && idx < 26 && !used[idx]) {
                used[idx] = true;
                ans += (count >= n ? '1' : '0');
            }

            prev = curr;
            count = 1;
        }
    }

    int idx = prev - 'a';
    if (0 <= idx && idx < 26 && !used[idx]) {
        used[idx] = true;
        ans += (count >= n ? '1' : '0');
    }

    std::cout << ans;


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}