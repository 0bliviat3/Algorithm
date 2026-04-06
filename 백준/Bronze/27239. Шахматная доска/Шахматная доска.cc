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

	int n;
	std::cin >> n;

	int mod = n % 8;
	int div = n / 8 - ((mod) ? 0 : 1) + 1;
	
	mod = (mod) ? mod : 8;

	std::cout << char('a' + mod - 1) << div;


}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}