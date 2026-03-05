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

    std::string number;
	std::cin >> number;


	int start = number[0] - '0';
    int cnt = 1;
    int ans = 0;
    for (int i = 1; i < number.length(); i++) {
		int now = number[i] - '0';
        if (now == start + 1) {
            cnt++;
        } else {
            if (cnt == 3) {
				ans++;
            }
            cnt = 1;
        }
		start = now;
    }
    if (cnt == 3) {
        ans++;
    }
    std::cout << ans;


}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    solve();
    return 0;
}