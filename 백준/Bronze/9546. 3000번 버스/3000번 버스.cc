#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	int n;
	std::cin >> n;
	
	while (n--) {
		int ans = 1;
		int k;
		std::cin >> k;
		k--;
		while (k--) {
			ans *= 2;
			ans++;
		}
		std::cout << ans << '\n';
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}