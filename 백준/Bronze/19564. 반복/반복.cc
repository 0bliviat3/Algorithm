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

	int start = s[0] - 'a';
    int count = 1;
    for (int i = 1; i < s.size(); i++) {
		int now = s[i] - 'a';
        if (now <= start) {
			count++;
        }
		start = now;
    }
	std::cout << count << "\n";


}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}